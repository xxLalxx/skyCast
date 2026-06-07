import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar implements OnInit {

  currentPlace: string = 'Locating...';
  currentState: string = '';

  ngOnInit() {
    this.getUserLocation();
  }

  onSearch(city: string) {
    if (!city.trim()) return;
    console.log('Searching for city:', city);
  }

  getUserLocation() {
    // Check if the browser supports getting location data
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const lat = position.coords.latitude;
          const lon = position.coords.longitude;
          
          this.fetchLocationName(lat, lon);
        },
        (error) => {
          console.error('Error getting location geolocation:', error);
          this.currentPlace = 'Location Disabled';
        }
      );
    } else {
      this.currentPlace = 'Unsupported Browser';
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
      })
      .catch(error => {
        console.error('Error fetching readable location name:', error);
        this.currentPlace = 'Location Error';
      });
  }

}
