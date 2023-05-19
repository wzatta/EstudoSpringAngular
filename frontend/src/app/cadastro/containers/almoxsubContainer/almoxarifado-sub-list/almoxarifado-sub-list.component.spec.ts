import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlmoxarifadoSubListComponent } from './almoxarifado-sub-list.component';

describe('AlmoxarifadoSubListComponent', () => {
  let component: AlmoxarifadoSubListComponent;
  let fixture: ComponentFixture<AlmoxarifadoSubListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlmoxarifadoSubListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlmoxarifadoSubListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
