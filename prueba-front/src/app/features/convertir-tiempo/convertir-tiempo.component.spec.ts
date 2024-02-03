import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvertirTiempoComponent } from './convertir-tiempo.component';

describe('ConvertirTiempoComponent', () => {
  let component: ConvertirTiempoComponent;
  let fixture: ComponentFixture<ConvertirTiempoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConvertirTiempoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConvertirTiempoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
