# Puzzles

## Balanced parens

```python
def parens(left, right, sequence):
  if left == 0 and right == 0:
    print(sequence)
  
  if left > 0:
    parens(left - 1, right + 1, sequence + "(")
  if right > 0:
    parens(left, right - 1, sequence + ")")
    
parens(10, 0, "")
```
