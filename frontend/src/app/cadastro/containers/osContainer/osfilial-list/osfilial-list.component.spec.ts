import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OsfilialListComponent } from './osfilial-list.component';

describe('OsfilialListComponent', () => {
  let component: OsfilialListComponent;
  let fixture: ComponentFixture<OsfilialListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OsfilialListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OsfilialListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
