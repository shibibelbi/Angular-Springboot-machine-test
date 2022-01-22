import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalescoordinatorComponent } from './salescoordinator.component';

describe('SalescoordinatorComponent', () => {
  let component: SalescoordinatorComponent;
  let fixture: ComponentFixture<SalescoordinatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalescoordinatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalescoordinatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
