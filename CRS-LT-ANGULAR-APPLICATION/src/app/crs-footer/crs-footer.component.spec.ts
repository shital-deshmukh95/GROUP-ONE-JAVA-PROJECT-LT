import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrsFooterComponent } from './crs-footer.component';

describe('CrsFooterComponent', () => {
  let component: CrsFooterComponent;
  let fixture: ComponentFixture<CrsFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrsFooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrsFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
