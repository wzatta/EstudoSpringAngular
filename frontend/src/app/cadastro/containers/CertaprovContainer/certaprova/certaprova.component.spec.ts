import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CertaprovaComponent } from './certaprova.component';

describe('CertaprovaComponent', () => {
  let component: CertaprovaComponent;
  let fixture: ComponentFixture<CertaprovaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CertaprovaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CertaprovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
