from django.urls import path
from .views import *

urlpatterns = [
    path('', home, name="home"),
    path('contacto', contacto, name="contacto"),
    path('conocenos', conocenos, name="conocenos"),
    path('adopciones', adopciones, name="adopciones"),
    path('agregar-adopcion', form_adopcion, name="form_adopcion"),
    path('modificar-adopcion/<id>', form_mod_adopcion, name="form_mod_adopcion"),
    path('borrar-adopcion/<id>', form_del_adopcion, name="form_del_adopcion"),
    path('dashboard', dashboard, name="dashboard"),
    path('login-screen', login_screen, name="login_screen")
]