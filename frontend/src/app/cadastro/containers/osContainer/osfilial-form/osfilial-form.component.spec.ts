import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OsfilialFormComponent } from './osfilial-form.component';

describe('OsfilialFormComponent', () => {
  let component: OsfilialFormComponent;
  let fixture: ComponentFixture<OsfilialFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OsfilialFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OsfilialFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
