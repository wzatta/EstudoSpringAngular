import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoMasterComponent } from './produto-master.component';

describe('ProdutoMasterComponent', () => {
  let component: ProdutoMasterComponent;
  let fixture: ComponentFixture<ProdutoMasterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProdutoMasterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutoMasterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
