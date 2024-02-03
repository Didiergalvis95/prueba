import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IEquipo } from '../interfaces/iequipo';
import { Observable } from 'rxjs';
import { IJugador } from '../interfaces/ijugador';
import { IEquipoResponse } from '../interfaces/iequipo-response';
import { IReporteBasico } from '../interfaces/ireporte-basico';
import { IReporteDetallado } from '../interfaces/ireporte-detallado';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  urlEquipo = 'http://localhost:8080/api/v1/equipo'

  constructor(private httpClient: HttpClient) { }

  crearEquipo(equipos: IEquipo[] | IEquipo): Observable<string> {
    const url = this.urlEquipo + '/crearequipo';
    const equiposArray = Array.isArray(equipos) ? equipos : [equipos];
    const options = { responseType: 'text' as 'json' };
  return this.httpClient.post<string>(url, equiposArray, options);
  }

  crearJugador(jugadores: IJugador[] | IJugador): Observable<string> {
    const url = this.urlEquipo + '/crearjugador';
    const jugadoresArray = Array.isArray(jugadores) ? jugadores : [jugadores];
    const options = { responseType: 'text' as 'json' };
    return this.httpClient.post<string>(url, jugadoresArray, options);
  }

  obtenerEquipos(): Observable<IEquipoResponse[]> {
    const url = this.urlEquipo + '/obtenerequipos';
    return this.httpClient.get<IEquipoResponse[]>(url);
  }

  getReporteDetallado(): Observable<IReporteDetallado[]> {
    const url =  this.urlEquipo +'/reportedetallado';
    return this.httpClient.get<IReporteDetallado[]>(url);
  }

  getReporteBasico(): Observable<IReporteBasico[]> {
    const url = this.urlEquipo + '/reportebasico';
    return this.httpClient.get<IReporteBasico[]>(url);
  }



}
