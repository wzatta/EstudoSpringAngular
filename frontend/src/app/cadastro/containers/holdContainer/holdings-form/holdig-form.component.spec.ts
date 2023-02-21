import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HoldigFormComponent } from './holdig-form.component';

describe('HoldigFormComponent', () => {
  let component: HoldigFormComponent;
  let fixture: ComponentFixture<HoldigFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoldigFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HoldigFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
