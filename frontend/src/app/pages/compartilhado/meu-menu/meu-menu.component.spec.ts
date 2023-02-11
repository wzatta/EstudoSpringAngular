import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeuMenuComponent } from './meu-menu.component';

describe('MeuMenuComponent', () => {
  let component: MeuMenuComponent;
  let fixture: ComponentFixture<MeuMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MeuMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MeuMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
