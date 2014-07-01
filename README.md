propExpr
========

expression based property reader for JSON/ reflection/ map ...

expression like 'person1.array[0].name.first_name[0]'

it will populate the value of the corresponding property.

person1<br/> 
|--array[0]<br/>
|&nbsp;&nbsp;&nbsp;&nbsp;|--name<br/>
|&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--first_name[0]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<-- target<br/>
|&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--first_name[..]<br/>
|&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|--first_name[n]<br/>
|--array[..]<br/>
|--array[n]<br/>