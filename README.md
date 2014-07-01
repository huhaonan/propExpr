propExpr
========

expression based property reader for json/ reflection/ map ...

expression like 'person1.array[0].name.first_name[0]'

it will populate the property of the corresponding property.

person1 
|--array[0]
|   |--name
|   |   |--first_name[0]    <-- target
|   |   |--first_name[..]
|   |   |--first_name[n]
|--array[..]
|--array[n]