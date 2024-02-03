import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TiempoService } from 'src/app/shared/service/tiempo.service';

@Component({
  selector: 'app-convertir-tiempo',
  templateUrl: './convertir-tiempo.component.html',
  styleUrls: ['./convertir-tiempo.component.css']
})
export class ConvertirTiempoComponent {
  tiempoForm: FormGroup;
  respuesta!: string | '';

  constructor(private formBuider: FormBuilder,
    private tiempoService: TiempoService){
      this.tiempoForm = this.formBuider.group({
        hora: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
        minuto: ['', [Validators.required, Validators.pattern(/^\d+$/)]]
      })
  }

  convertir(){
    if(this.tiempoForm.valid){
      const hora = this.tiempoForm.value.hora;
      const minuto = this.tiempoForm.value.minuto;

      this.tiempoService.convertirTiempo(hora, minuto).subscribe({
        next: (data: string) => {
          this.respuesta = data;
        },
        error: (error: any) => {
          console.error('Error al consultar el servicio', error);
        }
      });
    }
  }

  get horaControl() {
    return this.tiempoForm.get('hora');
  }

  get minutoControl() {
    return this.tiempoForm.get('minuto');
  }

  horaInvalido() {
    const control = this.horaControl;
    return control ? (control.invalid && (control.dirty || control.touched)) : false;
  }
  minutoInvalido() {
    const control = this.minutoControl;
    return control ? (control.invalid && (control.dirty || control.touched)) : false;
  }

}
