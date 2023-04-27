class Vehicle:
   def __init__(self, type, model, mpg):
     self.__type = type
     self.__model = model
     self.__mpg = int(mpg)
     self._canfly = False
     self._numWheels = 4

   def doesItFly(self):
      return self._canfly
   
   def doesItFly(self):
      return "hmmmm"
   
   def toString(self):
      flyable = " not"
      if self._canfly:
        flyable = ""
      return  self.__model + " " + self.noise() + " does" + flyable + " fly with " + str(self._numWheels) + " wheels."

class Car(Vehicle):
    def __init__(self, type, model, mpg):
        super().__init__(type, model, mpg)
   
    def noise(self):
      return "vroom"


class Truck(Vehicle):
   def __init__(self, type, model, mpg):
      super().__init__(type, model, mpg)
   
   def noise(self):
      return "bumbumbum"

class Motorcycle(Vehicle):
   def __init__(self, type, model, mpg):
      super().__init__(type, model, mpg)
      self._numWheels = 2
   
   def noise(self):
      return "errrrrrm"

class Plane(Vehicle):
   def __init__(self, type, model, mpg):
      super().__init__(type, model, mpg)
      self._numWheels = 3
      self._canfly = True
   
   def noise(self):
      return "woooosh"


