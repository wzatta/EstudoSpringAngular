import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubgrupoListComponent } from './subgrupo-list.component';

describe('SubgrupoListComponent', () => {
  let component: SubgrupoListComponent;
  let fixture: ComponentFixture<SubgrupoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubgrupoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubgrupoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
