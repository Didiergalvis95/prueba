import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NumerosParesComponent } from './features/numeros-pares/numeros-pares.component';
import { ConvertirTiempoComponent } from './features/convertir-tiempo/convertir-tiempo.component';
import { EquiposComponent } from './features/equipos/equipos.component';
import { HttpClientModule } from '@angular/common/http'
import { HomeComponent } from './features/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NumerosParesComponent,
    ConvertirTiempoComponent,
    EquiposComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
