import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubgrupoFormComponent } from './subgrupo-form.component';

describe('SubgrupoFormComponent', () => {
  let component: SubgrupoFormComponent;
  let fixture: ComponentFixture<SubgrupoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubgrupoFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubgrupoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
