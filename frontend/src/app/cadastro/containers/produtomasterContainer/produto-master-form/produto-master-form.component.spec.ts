import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoMasterFormComponent } from './produto-master-form.component';

describe('ProdutoMasterFormComponent', () => {
  let component: ProdutoMasterFormComponent;
  let fixture: ComponentFixture<ProdutoMasterFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProdutoMasterFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutoMasterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
