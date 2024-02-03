import { IJugador } from './../../shared/interfaces/ijugador';
import { IEquipo } from './../../shared/interfaces/iequipo';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipoService } from 'src/app/shared/service/equipo.service';
import { IEquipoResponse } from 'src/app/shared/interfaces/iequipo-response';
import { IReporteDetallado } from 'src/app/shared/interfaces/ireporte-detallado';
import { IReporteBasico } from 'src/app/shared/interfaces/ireporte-basico';

@Component({
  selector: 'app-equipos',
  templateUrl: './equipos.component.html',
  styleUrls: ['./equipos.component.css']
})
export class EquiposComponent implements OnInit {
  equipoForm!: FormGroup;
  jugadorForm!: FormGroup;
  equipos: IEquipoResponse[] = [];
  reporteDetalladoData!: IReporteDetallado[];
  reporteBasicoData!: IReporteBasico[];
  roles: string[] = ['Titular', 'Suplente'];

  mostrarFormularioEquipo: boolean = false;
  mostrarFormularioJugador: boolean = false;

  constructor(private formBuilder: FormBuilder, private equipoService: EquipoService) { }

  ngOnInit(): void {
    this.equipoForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      estadio: ['', Validators.required],
      titulo: ['', Validators.required],
    });
    this.jugadorForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      posicion: ['', Validators.required],
      rol: ['', Validators.required],
      equipoId: ['', Validators.required]
    });

    this.equipoService.obtenerEquipos().subscribe(
      (equipos: IEquipoResponse[]) => {
        this.equipos = equipos;
      },
      (error) => {
        console.error('Error al obtener equipos:', error);
      }
    );
  }

  toggleFormularioEquipo() {
    this.mostrarFormularioEquipo = !this.mostrarFormularioEquipo;
    if (!this.mostrarFormularioEquipo) {
      this.equipoForm.reset();
    }
  }

  toggleFormularioJugador() {
    this.mostrarFormularioJugador = !this.mostrarFormularioJugador;
    if (!this.mostrarFormularioJugador) {
      this.jugadorForm.reset();
    }
  }

  crearEquipo() {
    if (this.equipoForm.valid) {
      const equipoData: IEquipo = this.equipoForm.value;
  
      this.equipoService.crearEquipo(equipoData).subscribe({
        next: (data: string) => {
          console.log('Equipo creado con éxito:', data);
        },
        error: (error: any) => {
          console.error('Error al crear equipo:', error);
        }
      });
  
      this.equipoForm.reset();
      this.toggleFormularioEquipo();
    } else {
      console.error('El formulario no es válido. Por favor, complete todos los campos obligatorios.');
    }
  }

    crearJugador(){
      if (this.jugadorForm.valid) {
        const nombre = this.jugadorForm.value.nombre;
        const posicion = this.jugadorForm.value.posicion;
        const rol = this.jugadorForm.value.rol;
        const equipoId = this.jugadorForm.value.equipoId;

        const jugadorData: IJugador = {
          nombre: nombre,
          posicion: posicion,
          rol: rol,
          equipo: { id: equipoId } 
        };
        this.equipoService.crearJugador(jugadorData).subscribe({
          next: (data: string) => {
            console.log('Equipo creado con éxito:', data);
          },
          error: (error: any) => {
            console.error('Error al crear equipo:', error);
          }
        });
    
        this.jugadorForm.reset();
        this.toggleFormularioJugador();
      } else {
        console.error('El formulario no es válido. Por favor, complete todos los campos obligatorios.');
      }
    }

    generarReporteDetallado() {
      this.equipoService.getReporteDetallado().subscribe(data => {
        this.reporteDetalladoData = data;
      });
    }
  
    generarReporteBasico() {
      this.equipoService.getReporteBasico().subscribe(data => {
        this.reporteBasicoData = data;
      });
    }

}
