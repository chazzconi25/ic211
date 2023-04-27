from clock import Clock
from calendar import Calendar

class ClockCalendar(Clock, Calendar):
    def __init__(self, m, d, y, hours, minutes, seconds):
        super().set_Calendar(d,m,y)
        super().set_Clock(hours, minutes, seconds)

    def tick(self):
        super().tick()
        if self.hours == 0 and self.minutes == 0 and self.seconds == 0:
            super().advance()
        
    
    def __str__(self):
        return Calendar.__str__(self) + "," + Clock.__str__(self)


x = ClockCalendar(12,31,2013,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,28,1900,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,28,2000,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,7,2013,13,55,40)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)