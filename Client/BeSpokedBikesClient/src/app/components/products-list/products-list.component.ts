import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css' ,

  ]
})


export class ProductsListComponent implements OnInit {
  products: any[] = [];

  constructor(private productService: ProductService , private router: Router) {}

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  editProduct(id: number): void {
    this.router.navigate([`/products/${id}/edit`]);
  }
}
