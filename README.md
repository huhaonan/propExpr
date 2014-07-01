propExpr
========

expression based property visitor for JSON/ Reflection/ Map ...

expression like 'person1.array[0].name.first_name[0]'

it will populate the value of the corresponding property.

person1<br/> 
&nbsp;&nbsp;|--array[0]<br/>
&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--name<br/>
&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--first_name[0]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<-- target<br/>
&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--first_name[..]<br/>
&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--first_name[n]<br/>
&nbsp;&nbsp;|--array[..]<br/>
&nbsp;&nbsp;|--array[n]<br/>