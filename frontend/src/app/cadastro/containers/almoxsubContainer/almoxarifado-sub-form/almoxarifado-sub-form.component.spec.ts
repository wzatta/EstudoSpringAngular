import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlmoxarifadoSubFormComponent } from './almoxarifado-sub-form.component';

describe('AlmoxarifadoSubFormComponent', () => {
  let component: AlmoxarifadoSubFormComponent;
  let fixture: ComponentFixture<AlmoxarifadoSubFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlmoxarifadoSubFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlmoxarifadoSubFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
