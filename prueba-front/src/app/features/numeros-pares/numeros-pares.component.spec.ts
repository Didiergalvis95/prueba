import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumerosParesComponent } from './numeros-pares.component';

describe('NumerosParesComponent', () => {
  let component: NumerosParesComponent;
  let fixture: ComponentFixture<NumerosParesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NumerosParesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NumerosParesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
