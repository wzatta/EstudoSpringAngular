import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlmoxarifadoComponent } from './almoxarifado.component';

describe('AlmoxarifadoComponent', () => {
  let component: AlmoxarifadoComponent;
  let fixture: ComponentFixture<AlmoxarifadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlmoxarifadoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlmoxarifadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
