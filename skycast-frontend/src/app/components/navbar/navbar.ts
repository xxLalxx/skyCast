import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WeatherService } from '../../services/weather';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule], // Removed FormsModule since we use #cityInput template vars!
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar implements OnInit {

  currentPlace: string = 'Locating...';
  currentState: string = '';
  searchQuery: string = '';

  constructor(private weatherService: WeatherService) { }

  ngOnInit() {
    this.getUserLocation();
  }

  // Add this method inside your Navbar class in navbar.ts

goHome() {
  if (this.currentPlace && this.currentPlace !== 'Locating...' && this.currentPlace !== 'Location Disabled') {
    console.log('Navigating Home to current localized position:', this.currentPlace);
    this.weatherService.changeCity(this.currentPlace);
  } else {
    console.log('Navigating Home to default fallback city configuration.');
    this.weatherService.changeCity('LA');
  }
}

  onSearch(city: string) {
    if (!city || !city.trim()) return;
    
    console.log('Searching for city via navbar input:', city);
    
    // Broadcast the searched city out to the dashboard component listener
    this.weatherService.changeCity(city);
  }

  getUserLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const lat = position.coords.latitude;
          const lon = position.coords.longitude;
          
          this.fetchLocationName(lat, lon);
        },
        (error) => {
          console.error('Error getting geolocation:', error);
          this.currentPlace = 'Location Disabled';
          this.weatherService.changeCity('Kollam'); // Secure fallback configuration
        }
      );
    } else {
      this.currentPlace = 'Unsupported Browser';
      this.weatherService.changeCity('Kollam');
    }
  }

  fetchLocationName(lat: number, lon: number) {
    const geoApiUrl = `https://api.bigdatacloud.net/data/reverse-geocode-client?latitude=${lat}&longitude=${lon}&localityLanguage=en`;

    fetch(geoApiUrl)
      .then(response => response.json())
      .then(data => {
        this.currentPlace = data.city || data.locality || 'Unknown Location';
        this.currentState = data.principalSubdivision || '';
        
        console.log(`Location localized to: ${this.currentPlace}, ${this.currentState}`);
        
        // Broadcast browser auto-detected location on initial application startup
        this.weatherService.changeCity(this.currentPlace);
      })
      .catch(error => {
        console.error('Error fetching readable location name:', error);
        this.currentPlace = 'Location Error';
        this.weatherService.changeCity('Kollam');
      });
  }
}