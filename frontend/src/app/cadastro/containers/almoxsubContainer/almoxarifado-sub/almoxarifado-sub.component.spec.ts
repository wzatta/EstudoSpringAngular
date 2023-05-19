import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlmoxarifadoSubComponent } from './almoxarifado-sub.component';

describe('AlmoxarifadoSubComponent', () => {
  let component: AlmoxarifadoSubComponent;
  let fixture: ComponentFixture<AlmoxarifadoSubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlmoxarifadoSubComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlmoxarifadoSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
