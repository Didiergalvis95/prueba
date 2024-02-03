import { IJugadorResponse } from "./ijugador-response";

export interface IReporteDetallado {
    nombre: string;
    jugadores: IJugadorResponse[];
}
