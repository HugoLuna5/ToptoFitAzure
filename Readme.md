# TotoFit App con Azure


Problemática a resolver.
Detectar múltiples alimentos en una fotografía, dotando de información nutrimental a un usuario, esto para crear una solución para los nutriólogos cuando atienden a sus pacientes brindándoles un servicio y seguimiento más preciso.
Anteriormente ya había desarrollado una solución de IA para la detección de alimentos en fotografías, esta solución lleva el nombre de ToptoFit, esta es una aplicación móvil para Android e iOS que estuvo disponible el año pasado, donde por medio de una fotografía se analizaban que alimentos se encontraban en esta, y brindaba su información nutrimental. Cabe mencionar que este proyecto me hizo acreedor a una acreditación a un vento de tecnología en los Emiratos Árabes Unidos, pero por cuestiones de la pandemia este evento quedo pospuesto. Les dejo enlaces de referencia.


[ENEIT 2019](https://itsta.edu.mx/alumnos-obtienen-primeros-lugares-en-el-concurso-eneit-2019/)

[Proyecto Multimedia 2019](https://itsta.edu.mx/concluye-concurso-latinoamericano-proyectos-multimedia-zona-golgo-2019/)

[ToptoFit Versión 1 - 2019](https://play.google.com/store/apps/details?id=lunainc.com.mx.toptofit)



Para desarrollar en este momento esta solución de IA, use los servicios cognitivos con custom visión, agregando un set de imágenes propios que anteriormente había recolectado. También se hace uso de Prediction API para enlazar el modelo entrenado, con la solución final para el usuario que es una aplicación móvil para dispositivos Android. Para complementar la solución y para casos de pruebas se generaron unos scripts en Python para probar el modelo.


## Prueba del API de predicciones

![Predictions API](https://github.com/HugoLuna5/ToptoFitAzure/blob/1b7f77d4818f312a54630918e2b1f8233f0a80f7/img/2.png "API Predictions")

## Modelo
![Modelo](https://github.com/HugoLuna5/ToptoFitAzure/blob/1b7f77d4818f312a54630918e2b1f8233f0a80f7/img/2.png "Modelo")
