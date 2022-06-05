from django.urls import path
from .views import evento, index, logadm,login, quienes,registro, ubicacion,indexlog,quieneslog, ubicacionlog, eventolog,dashboard,estadistica,inventario, usuarios,ventas

urlpatterns = [
    path('',index,name="index"),
    path('login',login,name="login"),
    path('registro',registro,name="registro"),
    path('quienes',quienes,name="quienes"),
    path('ubicacion',ubicacion,name="ubicacion"),
    path('evento',evento,name="evento"),
    path('indexlog',indexlog,name="indexlog"),
    path('quieneslog',quieneslog,name="quieneslog"),
    path('ubicacionlog',ubicacionlog,name="ubicacionlog"),
    path('eventolog',eventolog,name="eventolog"),
    path('dashboard',dashboard,name="dashboard"),
    path('estadistica',estadistica,name="estadistica"),
    path('inventario',inventario,name="inventario"),
    path('ventas',ventas,name="ventas"),
    path('logadm',logadm,name="logadm"),
    path('usuarios',usuarios,name="usuarios")
    
    
    
]