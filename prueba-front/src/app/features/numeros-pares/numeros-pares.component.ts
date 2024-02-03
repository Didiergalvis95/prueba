import { NumeroService } from './../../shared/service/numero.service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-numeros-pares',
  templateUrl: './numeros-pares.component.html',
  styleUrls: ['./numeros-pares.component.css']
})
export class NumerosParesComponent {
  numeroForm: FormGroup;
  respuesta!: string | null;

  constructor(private formBuider: FormBuilder,
    private numeroService: NumeroService){
      this.numeroForm = this.formBuider.group({
        numero: ['', [Validators.required, Validators.pattern(/^\d+$/)]]
      })
  }

  validarNumero(){
    if(this.numeroForm.valid){
      const numero = this.numeroForm.value.numero;

      this.numeroService.consultarNumero(numero).subscribe({
        next: (data: string) => {
          this.respuesta = data;
        },
        error: (error: any) => {
          console.error('Error al consultar el servicio', error);
        }
      });
    }
  }

  get numeroControl() {
    return this.numeroForm.get('numero');
  }

  numeroInvalido() {
    const control = this.numeroControl;
    return control ? (control.invalid && (control.dirty || control.touched)) : false;
}

}
