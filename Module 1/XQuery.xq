Give the titles of all Books sorted by Price.

for $b in doc("bib.xml")//book
order by xs:float($b/price) descending, $b/title ascending
return $b/title

How many books were written by Abiteboul?

doc("bib.xml")//book[author = 'Abiteboul']

Give for each author, the number of books he has written.

for $a in distinct-values(doc("bib.xml")//author)
return <res>
 <name>{$a}</name>
 <count>
 {count(doc("bib.xml")//book[exists(index-of(author,$a))]) }
 </count>
 </res>

