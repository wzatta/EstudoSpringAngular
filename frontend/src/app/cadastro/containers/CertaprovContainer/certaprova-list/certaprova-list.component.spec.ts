import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CertaprovaListComponent } from './certaprova-list.component';

describe('CertaprovaListComponent', () => {
  let component: CertaprovaListComponent;
  let fixture: ComponentFixture<CertaprovaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CertaprovaListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CertaprovaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
