import { Component, OnInit } from '@angular/core';
import { ExpenseEntry } from 'src/expense-entry';
import { LogService } from 'src/log.service';
import { ExpenseEntryService } from '../expense-entry.service';
@Component({
   selector: 'app-expense-entry-list',
   templateUrl: './expense-entry-list.component.html',
   styleUrls: ['./expense-entry-list.component.css'],
   providers: [LogService]
})
export class ExpenseEntryListComponent implements OnInit {
   title: string;
   expenseEntries: ExpenseEntry[];
   constructor(private restService : ExpenseEntryService,
               public logger : LogService ) { }

   ngOnInit() {
      this.title = "Expense Entry List";
      this.getExpenseItems();
   }
   getExpenseItems() {
      this.restService.getExpenseEntries()
      .subscribe( data => this.expenseEntries = data );
   }
   deleteExpenseEntry(evt: { preventDefault: () => void; }, id: number | ExpenseEntry) {
      evt.preventDefault();
      if(confirm("Are you sure to delete the entry?")) {
         this.restService.deleteExpenseEntry(id)
            .subscribe( data => console.log(data) );
            this.getExpenseItems();
      }
   }  
}
