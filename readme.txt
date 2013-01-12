Problem (short): Given a number (upto a digit limit of 9), print the British English phrase of this.
Please see Sample.txt for output.

My approach to solve the problem: 

Approach 1: Algorithmic
Code: src/numbertextalgo
- Convert (123, 456, 789) = convert(123) + "million" + convert(456) + "thousand" + convert (789);
- Recursive method

Considering the space- and time-complexity associated with using Collections or hashing data structure and loading of classes (just to make it more and more OO), given the nature of the problem (I started with this approach first)
Code:

Approach 2: More OO: Incomplete solution. Yet to handle for some special cases 
Code: src/numbertexoo
I've used more of Object Oriented constructs here (more OO than approach 1) like using Triplet object for a set of max of numbers. The toString() is overridden to represent a specific triplet and also a number object.
Number object to be consisting of Triplet object array.  
I've not been able to get this working completely for all conditions, for some persons. But the logic can be workable.

See the Sample.txt for sample outputs for different runs.
