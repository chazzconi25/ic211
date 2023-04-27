class Point:
   def __init__(self, x, y):
     self.__x = x
     self.__y = y

   def dist_from_origin(self):
      return self.__x*self.__x + self.__y*self.__y
   def __str__(self):
      return "(" + str(self.__x) + "," + str(self.__y) + ")"

p1 = Point(5, 3)
p2 = Point(5.3, 3)
print(p1, p1.dist_from_origin())
print(p2, p2.dist_from_origin())
