# Testing plan

Things worth testing:

- Normal operation:
  - Each operation works on a normal set
- Edge cases:
  - Operations on empty sets
  - Operations on identical sets
- Misc.
  - Bitstring representation

## Implementation details

The way I came up with to test the multisets is to verify *certain substrings within* the `toString()` output of the union/intersection/whatever. The motivation for this was partly out of laziness, since I don't want to copy down all the elements for every multiset, but also because set implementations shouldn't guarantee certain orderings, and I don't want these tests to fail just because the output is suddenly backwards.
However, the string representation of the multisets we're using don't explicitly number the elements when there's only one of them, for example:

`[Beer x 3, Water, Diet Coke x 2]`

This makes testing for, in the above example, a single water, tricky. I can't put a `Water x 1` in the tests, since that doesn't work, and just testing for `Water` as a substring only shows that it's in there somewhere, but not that there's only one of it. My solution is to test for the comma afterwards, as in `Water,` and hope that it never shows at the very end where there's no comma.

Unfortunately, I didn't have the same order-agnostic foresight for the standard sets, so unless their test cases get rewritten, they're subject to panic when an ordering changes in set operations.
