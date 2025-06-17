import pandas as pd

print(pd.__version__)

ser_obj = pd.Series(range(10))

print(ser_obj)

print(ser_obj.values)
print(type(ser_obj.values))

print(ser_obj.index)

print(ser_obj.name)