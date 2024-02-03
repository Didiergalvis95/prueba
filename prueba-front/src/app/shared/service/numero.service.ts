import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumeroService {

  urlNumero = 'http://localhost:8080/api/v1/numero'

  constructor(private httpClient: HttpClient) { }

  consultarNumero(numero: number): Observable<string> {
    const url = this.urlNumero + '/entero';
    const params = new HttpParams().set('numero', numero.toString());
  
    const options = { params, responseType: 'text' as 'json' };
  
    return this.httpClient.get<string>(url, options);
  }
}
