import { Component,OnInit,OnDestroy } from '@angular/core';
import { WeatherService } from '../../services/weather';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-dashboard',
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit,OnDestroy {

  weatherData: any = null;
  forecastData: any[] = [];
  currentPlace: string = '';
  currentState: string = '';

  private searchSubscription!: Subscription;

  constructor(private weatherService: WeatherService) { }
  
  ngOnInit(): void {
    this.loadCurrentLocationWeather();
    this.searchSubscription = this.weatherService.searchCity$.subscribe({
      next: (city) => {
        if (city) {
          this.currentPlace = city; 
          this.currentState = '';  
          
          this.searchCityByBackend(city); 
        }
      }
    });
  }

  loadCurrentLocationWeather() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const lat = position.coords.latitude;
          const lon = position.coords.longitude;

          this.fetchLocationName(lat, lon);
        },
        (error) => {
          console.warn('Geolocation blocked. Falling back to default city.');
          this.searchCityByBackend('Kollam'); 
        }
      );
    } else {
      this.searchCityByBackend('Kollam');
    }
  }

  fetchLocationName(lat: number, lon: number) {
    const geoApiUrl = `https://api.bigdatacloud.net/data/reverse-geocode-client?latitude=${lat}&longitude=${lon}&localityLanguage=en`;

    fetch(geoApiUrl)
      .then(response => response.json())
      .then(data => {
        this.currentPlace = data.city || data.locality || 'Kollam';
        this.currentState = data.principalSubdivision || '';
        
        console.log(`Location localized to: ${this.currentPlace}, ${this.currentState}`);
        
    
        this.searchCityByBackend(this.currentPlace);
      })
      .catch(error => {
        console.error('Error fetching readable location name:', error);
        this.searchCityByBackend('Kollam'); // Fallback on API failure
      });
  }

  searchCityByBackend(city: string) {
    this.weatherService.getWeather(city).subscribe({
      next: (data) => {
        this.weatherData = data;
        console.log('Successfully received weather data from Spring Boot:', data);
      },
      error: (err) => {
        console.error('Backend connection failed:', err);
      }
    });

    this.weatherService.getForecast(city).subscribe({
      next: (data) => {
        this.forecastData = data;
        console.log('Successfully received forecast array:', data);
      },
      error: (err) => console.error('Forecast fetch failed:', err)
    });
  }

  getWeatherIcon(condition: string): string {
    if (!condition) return '☀️'; // Fallback default
    
    const cond = condition.toLowerCase();
    
    if (cond.includes('thunder') || cond.includes('storm')) return '⛈️';
    if (cond.includes('rain') || cond.includes('drizzle')) return '🌧️';
    if (cond.includes('snow') || cond.includes('sleet') || cond.includes('ice')) return '❄️';
    if (cond.includes('cloud') || cond.includes('overcast')) return '☁️';
    if (cond.includes('mist') || cond.includes('fog') || cond.includes('haze')) return '🌫️';
    if (cond.includes('clear') || cond.includes('sunny')) return '☀️';
    
    return '🌤️'; // Default fallback icon 
  }

  ngOnDestroy(): void {
    if (this.searchSubscription) {
      this.searchSubscription.unsubscribe();
    }
  }

}
