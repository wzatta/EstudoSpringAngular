import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CertaprovaFormComponent } from './certaprova-form.component';

describe('CertaprovaFormComponent', () => {
  let component: CertaprovaFormComponent;
  let fixture: ComponentFixture<CertaprovaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CertaprovaFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CertaprovaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
