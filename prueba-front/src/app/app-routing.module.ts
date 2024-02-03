import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NumerosParesComponent } from './features/numeros-pares/numeros-pares.component';
import { ConvertirTiempoComponent } from './features/convertir-tiempo/convertir-tiempo.component';
import { EquiposComponent } from './features/equipos/equipos.component';
import { HomeComponent } from './features/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'home', component: HomeComponent},
  {path: 'numero', component: NumerosParesComponent},
  {path: 'tiempo', component: ConvertirTiempoComponent},
  {path: 'equipo', component: EquiposComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
