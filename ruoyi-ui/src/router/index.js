{
  path: '/followup',
  component: Layout,
  hidden: false,
  children: [
    {
      path: 'doctor',
      component: () => import('@/views/followup/doctor/index'),
      name: 'Doctor',
      meta: { title: '医生管理', icon: 'user' }
    }
  ]
} 