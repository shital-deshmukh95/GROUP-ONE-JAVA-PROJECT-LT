import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewGadeCardComponent } from './view-gade-card.component';

describe('ViewGadeCardComponent', () => {
  let component: ViewGadeCardComponent;
  let fixture: ComponentFixture<ViewGadeCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewGadeCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewGadeCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
