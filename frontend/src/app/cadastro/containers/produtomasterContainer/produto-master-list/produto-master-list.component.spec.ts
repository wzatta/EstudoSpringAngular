import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoMasterListComponent } from './produto-master-list.component';

describe('ProdutoMasterListComponent', () => {
  let component: ProdutoMasterListComponent;
  let fixture: ComponentFixture<ProdutoMasterListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProdutoMasterListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdutoMasterListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
