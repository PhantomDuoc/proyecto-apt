from django.urls import path
from rest_adopcion.views import lista_adopciones, detalle_adopciones
from rest_adopcion.viewsLogin import login

urlpatterns = [
    path('lista_adopciones', lista_adopciones, name="lista_adopciones"),
    path('detalle_adopciones/<id>',detalle_adopciones,name='detalle_adopciones'),
    path('login',login,name='login')
]