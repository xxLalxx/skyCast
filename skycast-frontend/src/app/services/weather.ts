import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  
  private searchSubject = new BehaviorSubject<string>('');
  searchCity$ = this.searchSubject.asObservable();
  
  private baseUrl = 'http://localhost:8080/v1/api/weather';

  constructor(private http: HttpClient) { }

  changeCity(city: string) {
    if (city && city.trim() !== '') {
      this.searchSubject.next(city);
    }
  }

  getWeather(city: string): Observable<any> {
    const url = `${this.baseUrl}/city/{city}?city=${city}`;
    return this.http.get<any>(url);
  }

  getForecast(city: string): Observable<any> {
    const url = `${this.baseUrl}/forecast/{city}?city=${city}`;
    return this.http.get<any>(url);
  }
}