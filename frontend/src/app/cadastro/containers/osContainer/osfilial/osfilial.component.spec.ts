import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OsfilialComponent } from './osfilial.component';

describe('OsfilialComponent', () => {
  let component: OsfilialComponent;
  let fixture: ComponentFixture<OsfilialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OsfilialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OsfilialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
