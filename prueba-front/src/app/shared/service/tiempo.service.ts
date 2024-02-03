import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TiempoService {

  urlTiempo = 'http://localhost:8080/api/v1/hora'

  constructor(private httpClient: HttpClient) { }

  convertirTiempo(hora: number, minuto:number): Observable<string>{
    const url = this.urlTiempo + '/convertirtiempo'

    let params = new HttpParams();
    params = params.set('hora', hora.toString());
    params = params.set('minuto', minuto.toString());

    const options = { params, responseType: 'text' as 'json' };

    return this.httpClient.get<string>(url, options);
  }
}
