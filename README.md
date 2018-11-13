# FamilyTree
Java Code for  Scan and Print Hierarchy
The Code is using maven, the simple-json dependency
input: json file with nodes
output: print to the console the hierarchy.
example:

output:

1 base1
--11 base11
--12 base12
----121 base121
----122 base122
------1221 base1221
----123 base123
2 base2
--21 base21
--22 base22
--23 base23
----231 base231
----232 base232
----233 base234
----234 base234

input:

[
  {
	"pid": 1,
	"ppid": null,
	"name": "base1"
  },
  {
	"pid": 2,
	"ppid": null,
	"name": "base2"
  },
  {
	"pid": 11,
	"ppid": 1,
	"name": "base11"
  },
  {
	"pid": 12,
	"ppid": 1,
	"name": "base12"
  },
  {
	"pid": 121,
	"ppid": 12,
	"name": "base121"
  },
  {
	"pid": 21,
	"ppid": 2,
	"name": "base21"
  },
  {
	"pid": 22,
	"ppid": 2,
	"name": "base22"
  },
  {
	"pid": 23,
	"ppid": 2,
	"name": "base23"
  },
  {
	"pid": 231,
	"ppid": 23,
	"name": "base231"
  },
  {
	"pid": 232,
	"ppid": 23,
	"name": "base232"
  },
  {
	"pid": 233,
	"ppid": 23,
	"name": "base234"
  },
  {
	"pid": 234,
	"ppid": 23,
	"name": "base234"
  },
  {
	"pid": 122,
	"ppid": 12,
	"name": "base122"
  },
  {
	"pid": 123,
	"ppid": 12,
	"name": "base123"
  },
  {
	"pid": 1221,
	"ppid": 122,
	"name": "base1221"
  }
]
